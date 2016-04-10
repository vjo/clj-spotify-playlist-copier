(ns clj-spotify-playlist-copier.core
  (:require [clj-spotify.core :as sptfy]))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn add-tracks-to-playlist [user-id playlist-id tracks token]
  (let [{:keys [error snapshot_id]} (sptfy/add-tracks-to-a-playlist {:user_id user-id :playlist_id playlist-id :uris tracks} token)]
    (cond
      error (exit 1 error))
    snapshot_id))

(defn create-playlist [user-id name public? token]
  (let [{:keys [error id]} (sptfy/create-a-playlist {:user_id user-id :name name :public public?} token)]
    (cond
      error (exit 1 error))
    id))

(defn get-playlist-to-copy [user-id playlist-name-to-copy token]
  (let [{:keys [error items]} (sptfy/get-a-list-of-a-users-playlists {:user_id user-id :limit 50 :offset 0} token)]
    (cond
      error (exit 1 error))
    (let [{:keys [id owner]} (first (filter #(= playlist-name-to-copy (:name %)) items))
          owner-id (:id owner)]
      {:playlist-id-to-copy id
       :playlist-owner-id-to-copy owner-id})))

(defn get-playlist-tracks [playlist-id owner-id token]
  (let [{:keys [error items]} (sptfy/get-a-playlists-tracks {:playlist_id playlist-id :owner_id owner-id :fields "items(track.uri)" :limit 50 :offset 0} token)]
    (cond
      error (exit 1 error))
    (map :uri (map :track items))))

(defn do-copy [& {:keys [user-id token playlist-name-to-copy playlist-name-new public?]}]
  (let [{:keys [playlist-id-to-copy playlist-owner-id-to-copy]} (get-playlist-to-copy user-id playlist-name-to-copy token)
        tracks (get-playlist-tracks playlist-id-to-copy playlist-owner-id-to-copy token)
        playlist-id-new (create-playlist user-id playlist-name-new public? token)
        snapshot-id (add-tracks-to-playlist user-id playlist-id-new tracks token)]))

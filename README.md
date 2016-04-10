[![Clojars Project](https://img.shields.io/clojars/v/clj-spotify-playlist-copier.svg)](https://clojars.org/clj-spotify-playlist-copier)

# clj-spotify-playlist-copier

A Clojure library designed to copy/duplicate Spotify playlists.

Built on the top of [clj-spotify](https://github.com/blmstrm/clj-spotify).

## Limitations

* The playlist to copy should be in your 50 first playlists.
* The playlist should be less than 50 songs.

## Usage
```Clojure
[clj-spotify-playlist-copier "0.1.0"]
```

```Clojure
(ns my.ns
  (:require [clj-spotify-playlist-copier.core :as sptfy-playlist-copier]))

(sptfy-playlist-copier/do-copy :user-id "me" :token "BQBw-JtC..._7GvA" :playlist-name-to-copy "Discover Weekly" :playlist-name-new "Discover Weekly Saved" :public? true)
```

## License

The MIT License (MIT)

Copyright (c) 2016 Victor Jolissaint

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

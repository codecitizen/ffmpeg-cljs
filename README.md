# ffmpeg-cljs

A FFmpeg wrapper for ClojureScript. This is a copy of 
[runexec](https://github.com/runexec)'s 
[implementation for Clojure](https://github.com/runexec/ffmpeg-clj) but
using [cljs.node.shell](https://github.com/bolasblack/cljs.nodejs.shell)
instead of `clojure.java.shell`, so you can run it in node.

```clojure
ffmpeg-cljs.core> (version)
"4.0.1"
ffmpeg-cljs.core> (cmd :i "vid1.mp4" "vid1.avi")
["ffmpeg" "-i" "vid1.mp4" "vid1.avi"]
ffmpeg-cljs.core> (ffmpeg! :i "1.mp4" "1.avi")
""
```
## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
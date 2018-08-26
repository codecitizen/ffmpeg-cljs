(ns ffmpeg-cljs.core
    (:require [cljs.nodejs.shell :refer [sh]]
              [clojure.string :as s]))

(def ^:dynamic *bin* "ffmpeg")

(defn cmd [& argv] 
    (->> argv
        (map #(if (keyword? %) (str "-" (name %)) (str %)))
        (into [*bin*])))

(defn bin [] *bin*)

(defn ffmpeg! [& args]
    (let [cmd! (apply sh (apply cmd args))
        {:keys [exit out err]} cmd!]
    (when-not (zero? exit)
        (throw
        (js/Error. (.toString err))))
        (.toString out)))

(defn version [] 
    (as-> (ffmpeg! "-version") o
        (re-find #"version \S+" o)
        (s/split o #" ")
        (last o)))
(ns clj.new.clj-web-template
  (:require [clj.new.templates :refer [renderer project-data ->files]]))

(defn clj-web-template
  "FIXME: write documentation"
  [name]
  (let [render (renderer "clj-web-template")
        data   (project-data name)]
    (println "Generating fresh 'clj new' clj-web-template project.")
    (->files data
             ["deps.edn" (render "deps.edn" data)]
             ["src/{{nested-dirs}}/handler.clj" (render "handler.clj" data)])))

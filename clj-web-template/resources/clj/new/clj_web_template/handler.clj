(ns {{namespace}}.handler
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
            [compojure.route :as route])
  (:gen-class))

(defroutes app
  (GET "/health" _ (constantly {:status 200 :body "ok"}))
  (->
   (GET "/" _ (constantly {:status 200 :body {:version 0}}))
   (wrap-json-body {:keywords? true :bigdecimals? true})  
   (wrap-json-response))
  (route/not-found "<h1>not found</h1>"))

(defn -main
  [& _]
  (try
    (println "... run-jetty")
    (run-jetty app {:port 3000})
    (catch Throwable t
      (println "failed to start " t))))



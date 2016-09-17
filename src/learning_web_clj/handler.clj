(ns learning-web-clj.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (or (str "Hello World") :next))
  (GET "/name" {params :params} (or (str "Hello, " (params :name)) :next))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))


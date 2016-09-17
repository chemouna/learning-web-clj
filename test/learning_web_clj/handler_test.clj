(ns learning-web-clj.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [learning-web-clj.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "name route"
    (let [response (app (mock/request :get "/name" {:name "Mouna"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello, Mouna"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))

(ns estudo-1.to-json
  (:require [cheshire.core :as json]))

(def my-map {:name "lima" :age 27 :city "Cascavel-PR"})

(def json-str (json/generate-string my-map))

(println json-str)

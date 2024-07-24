(ns estudo-1.namespace
  (:require
    [clojure.string :as my-str]
    [clojure.string :refer [join capitalize]]
    [clojure.string :as-alias my-string]
    )
  (:import
    [java.util Date UUID]
    [java.time Instant]
    )
  )

(my-str/join "jakson" "lima")
(join "jakson" "lima")
(capitalize "jakson lima")

(str (UUID/randomUUID))
(str (Date.))
(.toString (Date.))

(str (Instant/now))

(defrecord Type [name])

(->Type (UUID/randomUUID))
(map->Type {:name (str (UUID/randomUUID))})

(ns estudo-1.estudo_2)

(defn run [] (println "test-1") (println "test-2") (+ 1 1))

;(ref {})
;(atom {})
;(protocol? {})

(defn execute [] (pop (pop (conj [1 2 3] 4))))

(def my-ref (ref {}))

(dosync (alter my-ref assoc :key "value" :name "test"))

(defn read-ref [] (println @my-ref))

(def my-atom (atom {}))

(swap! my-atom assoc :key "value")

(defn read-atom [] (println @my-atom))

(defprotocol MyProtocol (my-method [this] "a simple method"))

(extend-type clojure.lang.IPersistentMap MyProtocol
  (my-method [this] (println "this is a map with keys:" (keys this))))

(defn callProto [] (my-method {:a 1 :b 2}))

(defprotocol MyProtocol2
  (get-value [this])
  (set-value [this new-value]))

(defrecord MyRecord [value]
  MyProtocol2
  (get-value [this] value)
  (set-value [this new-value] (assoc this :value new-value)))

(def my-record (->MyRecord 10))

(def my-atom2 (atom my-record))

;(defn geted [] (get-value @my-atom2))
;
;(defn seted [value] (swap! my-atom2 set-value value))

(defn process-protocol [protocol-instance]
  (println "Current value:" (get-value protocol-instance))
  (let [new-instance (set-value protocol-instance 100)]
    (println "New value:" (get-value new-instance))
    new-instance))

;(process-protocol my-record)

(defn process-protocol-2 [protocol-instance]
  (println "Current value:" (get-value @protocol-instance))
  (let [new-instance (swap! protocol-instance set-value 300)]
    (println "New value:" (get-value new-instance))
    new-instance)
  (println "Original:" (get-value @protocol-instance)))

(process-protocol-2 my-atom2)
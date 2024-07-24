(ns estudo-1.flow-control)

(even? 8)

(str "2 is " (if (even? 2) "even" "odd"))
(if (true? false) "impossible!")
(do (println "even"))
(if (even? 5)
  (do (println "even")
      true)
  (do (println "odd")
      false))

(when (neg? 1)
  (throw (RuntimeException. (str "x must be positive: " -1))))

(let [x 5]
  (cond
    (< x 2) "x is less than 2"
    (< x 10) "x is less than 10"))

(let [x 11]
  (cond
    (< x 2)  "x is less than 2"
    (< x 10) "x is less than 10"
    :else  "x is greater than or equal to 10"))

(defn foo [x]
  (case x
    5 "x is 5"
    10 "x is 10"))

(defn foo [x]
  (case x
    5 "x is 5"
    10 "x is 10"
    "x isn't 5 or 10"))

(foo 0)

(dotimes [i 3]
  (println i))

(doseq [n (range 3)]
  (println n))

(doseq [letter [:a :b]
        number (range 3)] ; list of 0, 1, 2
  (prn [letter number]))

(for [letter [:a :b :c]
      number (range 3)] ; list of 0, 1, 2
  [letter number])

(for [x (range 6)]
  (+ x x))

(for [x [1 2 3 4 5]
      y [10 20 30]
      :when (odd? x)]
  (* x y))

(odd? 5)

(loop [i 0]
  (println "executou" i)
  (if (< i 10)
    (recur (inc i))
    i))

(try
  (/ 2 0)
  (catch ArithmeticException e "divide by zero")
  (catch RuntimeException e "RuntimeException")
  (catch Exception e "Exception")
  (finally (println "cleanup"))
  )

(try
  (throw (ex-info "There was a problem" {:detail 42}))
  (catch Exception e
    (prn (:detail (ex-data e)))))

(try
  (throw (Exception. "something went wrong"))
  (catch Exception e (.getClass e)))

(let [f (clojure.java.io/writer "/tmp/new")]
  (try
    (.write f "some text")
    (finally
      (.close f))))

(with-open [f (clojure.java.io/writer "/tmp/new")]
  (.write f "some text"))
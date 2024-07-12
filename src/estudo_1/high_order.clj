(ns estudo-1.high-order)


(defn printed
  [v]
  (println v))

(defn high-order
  []
  printed)

(defn taxa-http
  []
  0.3)

(defn imposto
  [taxa-http salario]
  (if (< salario 1000)
    0
    (* salario taxa-http)))


(imposto (taxa-http) 1000)

(defn imposto
  [fn-taxa-http salario]
  (if (< salario 1000)
    0
    (* salario (fn-taxa-http))))

(imposto taxa-http 100)

(defn high-order-1
  []
  (fn [x y] (+ x y)))

(defn consulta-taxa-http
  []
  (println "http external")
  0.1)


(defn consulta-taxa-db
  []
  (println "db taxa")
  0.2)

(defn escolhe-consulta-taxa-padrao
  [ambiente]
  (if (= ambiente :test)
    consulta-taxa-db
    consulta-taxa-http))

(escolhe-consulta-taxa-padrao :test)

(def person-v3 {:name :test :age 27})

(fn [v] (* 2 v))

(#(* 2 %) 2)

(map #(* 2 %) '(1 2 3))

(#(* %1 %2) 2 2)

(constantly 0.2)
((constantly 0.2))
(concat [1 2] [3 4])
(rest [1 2 3])
(first [1 2 3])
(second [1 2 3])
(take 2 [1 2 3 4])
(drop 2 [1 2 3 4])
(interpose :a [1 2 3])
(partition 2 [1 2 3 4 5 6])
(range 5)
(repeat 3 :a)
(take 5 (iterate inc 1))

(assoc {:a 1} :b 2) ; => {:a 1, :b 2}
(dissoc {:a 1, :b 2} :a) ; => {:b 2}

(update {:a 1} :a inc) ; => {:a 2}
(update-in {:a {:b 1}} [:a :b] inc) ; => {:a {:b 2}}
(apply + [1 2 3])

(def add5 (partial + 5))
(add5 3) ; => 8

(if true "yes" "no") ; => "yes"
(when true "yes") ; => "yes"
(cond
  (= 1 1) "one"
  (= 2 2) "two") ; => "one"

(println "Hello, World!")

(spit "test.txt" "Hello, World!")
(slurp "test.txt") ; => "Hello, World!"

(for [x [1 2 3 4 5]]
  (* x x))

(for [i (range 10)]
  (println i))

(for [x (range 10) :when (even? x)] (println x))


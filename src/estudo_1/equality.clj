(ns estudo-1.equality)

(= 2 (+ 1 1))
(= (str "fo" "od") "food")
(= (float 314.0) (double 314.0))
(= 3 3N)
(= 2 2.0)
(range 3)
(= [0 1 2] (range 3))
(= [0 1 2] '(0 1 2))
(= [0 1 2] [0 2 1])
(= [0 1] [0 1 2])
(= '(0 1 2) '(0 1 2.0))
(def s1 #{1999 2001 3001})
(def s2 (sorted-set 1999 2001 3001))
(= s1 s2)
(def m1 (sorted-map-by > 3 -7 5 10 15 20))
(def m2 {3 -7, 5 10, 15 20})
(= m1 m2)

(def v1 ["a" "b" "c"])
(def m1 {0 "a" 1 "b" 2 "c"})
(def my-key :id)
(v1 0)
(m1 1 "my")
(= v1 m1)

(def s1 (with-meta #{1 2 3} {:key1 "set 1"}))
(def s2 (with-meta #{1 2 3} {:key1 "set 2 here"}))
(binding [*print-meta* true] (pr-str s1))
(binding [*print-meta* true] (pr-str s2))
(= s1 s2)
(= (meta s1) (meta s2))

(defrecord MyRec1 [a b])
(def r1 (->MyRec1 1 2))

(defrecord MyRec2 [a b])
(def r2 (->MyRec2 3 4))
(def m1 {:a 1 :b 2})
(= r1 r2)
(= r1 m1)
(into {} r1)
(= (into {} r1) m1)
(= (int 1) (long 1))
(def d1 (apply + (repeat 100 0.1)))
(apply - [1 2 3])
(Math/sqrt -1)
(= ##NaN ##NaN)
(def my-array [1 2 3])
(conj my-array 10)
(remove #(#{1 2 4} %) my-array)

(hash ["a" 5 :c])
(hash (->MyRec2 2 3))

(def java-list (java.util.ArrayList. [1 2 3]))
(def clj-vec [1 2 3])
(= java-list clj-vec)
(class java-list)
(class clj-vec)

(def grid-keys (for [x (range 10), y (range 10)]
                 [x y]))





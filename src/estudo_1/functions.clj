(ns estudo-1.functions
  (:require [estudo-1.to-json :refer [parse-smile]]))


(defn messenger
  ([]      (messenger "Hello world!"))
  ([msg]  (println msg))
  )
(messenger)
(messenger "test")

(defn hello [greeting & who]
  (println greeting who))
(hello "who")
(hello "Hello" "world" "class")

((fn  [message]  (println message) ) "function anonymous")

(defn greet [name] (str "Hello, " name))
(def greet (fn [name] (str "Hello, " name)))

;; Equivalent to: (fn [x] (+ 6 x))
#(+ 6 %)
;; Equivalent to: (fn [x y] (+ x y))
#(+ %1 %2)
;; Equivalent to: (fn [x y & zs] (println x y zs))
(#(println %1 %2 %&) 1 2 3 4 5)

#(vector %)
(fn [x] [x])
(vector 1 "")

(apply println "apply" "one")
(defn f [one two three four] (println one two three four))
(apply f '(1 2 3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 '(2 3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 2 '(3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 2 3 '(4))    ;; same as  (f 1 2 3 4)
(def proxy #(println %1 %2 %3))
(defn plot [shape coords]   ;; coords is [x y]
  (proxy shape (first coords) (second coords)))
(defn plot [shape coords]
  (apply proxy shape coords))
(plot "proxy" [1 2])

(let [x 1 y 2] (+ x y))
(defn messenger
  [msg]
  (let [a 7
        b 5
        c (clojure.string/capitalize msg)]
    (println a b c)
    ) ;; end of let scope
  ) ;; end of function
(messenger "capitalize")

(defn messenger-builder [greeting]
  (fn [who] (println greeting who)))
(def hello-er (messenger-builder "Hello"))
(hello-er "world!")

;new Widget("foo") | (Widget. "foo")
;rnd.nextInt() | (.nextInt rnd)
;object.field | (.-field object)
;Math.sqrt(25) | (Math/sqrt 25)
;Math.PI | Math/PI

((fn [obj] (.length obj)) "tests")
(#(.length %) "test")

;(source identity)
;(source constantly)

(defn http-get [url]
  (slurp url))
(http-get "https://jsonplaceholder.typicode.com/users")
(parse-smile (http-get "https://jsonplaceholder.typicode.com/users"))
(assert (.contains (http-get "https://www.w3.org") "html"))










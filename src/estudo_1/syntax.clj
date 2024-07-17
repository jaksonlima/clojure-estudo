(ns estudo-1.syntax
  (:require [clojure.string :refer [upper-case]])
  (:require [clojure.string :refer [lower-case]])
  (:require [clojure.repl :refer :all])
  )

42        ; integer
-1.5      ; floating point
22/7      ; ratio

"hello"         ; string
\e              ; character
#"[0-9]+"       ; regular expression

(type map)             ; symbol
+               ; symbol - most punctuation allowed
clojure.core/+  ; namespaced symbol
nil             ; null value
true false      ; booleans
:alpha          ; keyword
:release/alpha  ; keyword with namespace

'(1 2 3)     ; list
[1 2 3]      ; vector
#{1 2 3}     ; set
{:a 1, :b 2} ; map

(doc map)
(doc rem)
(apropos "+")
(dir clojure.repl)

(prn "one")
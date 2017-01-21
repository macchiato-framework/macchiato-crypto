(ns macchiato.bcrypt
  (:require [cljs.nodejs :as node]))

(def ^:private bcrypt (node/require "bcrypt"))

(defn encrypt
  "salt and hash the password, defaults to 11 rounds"
  ([raw] (encrypt raw 11))
  ([raw rounds] (bcrypt.hashSync raw rounds)))

(defn check
  "compares plain text password with the hash returns a boolean"
  [raw hash]
  (bcrypt.compareSync raw hash))

(defn encrypt-async
  "salt and hash the password, defaults to 11 rounds
  callback should accept the following arguments: err, result
  result is the hashed password"
  ([raw cb] (encrypt-async raw 11 cb))
  ([raw rounds cb]
   (bcrypt.hash raw rounds cb)))

(defn check-async
  "compares plain text password with the hash
  callback should accept the following arguments: err, result
  result is a boolean"
  [raw hash cb]
  (bcrypt.compare raw hash cb))

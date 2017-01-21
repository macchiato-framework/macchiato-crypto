### a library for securely hashing passwords

Following algorithms are supported:

* [Bcrypt](http://bcrypt.sourceforge.net/)
* [scrypt](http://www.tarsnap.com/scrypt.html)

[![CircleCI](https://circleci.com/gh/macchiato-framework/macchiato-crypto.svg?style=svg)](https://circleci.com/gh/macchiato-framework/macchiato-crypto)

[![Clojars Project](https://img.shields.io/clojars/v/macchiato/crypto.svg)](https://clojars.org/macchiato/crypto)

## Usage

Pick an encryption algorithm, either `bcrypt` or `scrypt`:

```clojure
(require '[macchiato.crypto.<algorithm> :as password])
```

Then use the `encrypt` function to apply a secure, one-way encryption
algorithm to a password:

```clojure
(def encrypted (password/encrypt "foobar"))
```

And the `check` function to check the encrypted password against a
plaintext password:

```clojure
(password/check "foobar" encrypted) ;; => true
```

The `encrypt` and `check` functions have async versions as well:

```clojure
(password/encrypt-async
  "secret"
  (fn [err result]
    (is (scrypt/check "secret" result))))

(password/check-async
  "secret"
  (password/encrypt "secret")
  (fn [err result]
    (is result)))
```

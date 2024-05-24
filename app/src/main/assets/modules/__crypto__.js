// noinspection JSUnusedLocalSymbols

module.exports = function (runtime, global) {

    const Crypto = org.autojs.autojs.core.crypto.Crypto;

    return {
        Key: Crypto.Key,
        KeyPair: Crypto.KeyPair,
        digest: Crypto.digest.bind(Crypto),
        encrypt: Crypto.encrypt.bind(Crypto),
        decrypt: Crypto.decrypt.bind(Crypto),
        generateKeyPair: Crypto.generateKeyPair.bind(Crypto),
    };
};
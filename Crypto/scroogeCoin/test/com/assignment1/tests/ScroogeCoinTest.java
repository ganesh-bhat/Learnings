package com.assignment1.tests;

import com.assignment1.Crypto;
import com.assignment1.Transaction;
import com.assignment1.TxHandler;
import com.assignment1.UTXOPool;
import org.junit.Test;

import java.security.*;

/**
 * Created by ganes on 03-02-2018.
 */
public class ScroogeCoinTest {

    @Test
    public void testCoin() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {


        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey scroobyPriv = pair.getPrivate();
        PublicKey scroobyPub = pair.getPublic();

        Transaction txn = new Transaction();
        txn.addInput(null, 0);
        txn.addOutput(5,scroobyPub);

        Signature dsa = Signature.getInstance("SHA256withRSA");
        dsa.initSign(scroobyPriv);
        byte[] rawDataToSign = txn.getRawDataToSign(0);
        dsa.update(rawDataToSign, 0, rawDataToSign.length);
        byte[] signature = dsa.sign();
        txn.addSignature(signature,0);

        boolean isValidSignature = Crypto.verifySignature(scroobyPub,rawDataToSign,signature);

        System.out.println("isValidSign:" + isValidSignature);
        TxHandler txHandler = new TxHandler(new UTXOPool());
       // txHandler.handleTxs();
       // txHandler.isValidTx();
    }
}

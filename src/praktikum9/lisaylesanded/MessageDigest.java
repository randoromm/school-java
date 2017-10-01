//package praktikum9.lisaylesanded;
//
//import org.apache.commons.codec.digest.DigestUtils;
///**
// * Cracking a 4 letter password with hashcode.
// * Created by rando on 15.10.16.
// */
//public class MessageDigest {
//    public static void main(String[] args) {
//        String d1, d2, d3, d4;
//        String digits = "0123456789abcdefghijklmnopqrstuvwxyz";
//        String defHash = "fd21ae5b17d8a85257936fc23c78ca5c";
//
//        outerLoop:
//        for(int i = 0; i < 36; i++){
//            d1 = digits.substring(i, i+1 );
//            for(int j = 0; j < 36; j++ ) {
//                d2 = d1 + digits.substring(j, j+1 );
//                for(int k = 0; k < 36; k++ ) {
//                    d3 = d2 + digits.substring(k, k+1 );
//                    for(int m = 0; m < 36; m++) {
//                        d4 = d3 + digits.substring( m, m+1 );
//                        if (DigestUtils.md5Hex(d4).equals(defHash)) {
//                            System.out.println(d4);
//                            break outerLoop;
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

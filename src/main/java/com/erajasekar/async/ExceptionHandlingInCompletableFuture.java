package com.erajasekar.async;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingInCompletableFuture {
    public static void main(String[] args) {

        try {
           /*  parseNumber("0").thenAccept(v -> {
                if (v == -1) {
                    System.out.println("Got Error");
                }
                try {
                    System.out.println(100/v);
                }catch (ArithmeticException e){
                    System.out.println("Handled inside CF " + e.getMessage());
                }
                System.out.println(100/v);

            }).exceptionally(e -> {
                System.out.println("Unhandled Exception in CF " + e.getMessage());
                return null;
            });

           parseNumber("0").thenAccept(v -> {
                if (v == -1) {
                    System.out.println("Got Error");
                }
                System.out.println(100/v);
            }).whenComplete( (v , t)-> {
                System.out.println("Completed " + v + " Exp " + t.getMessage());
            });

            parseNumber("a").handle((v , t)-> {
                System.out.println("Exception in Handle " + t.getMessage());
                return -3;
            })

            CompletableFuture<Double> cf = parseNumber("51").thenApply(v -> {
                if (v == -1) {
                    System.out.println("Got Error");
                }
                return 100.0 / v;
            });
           /* cf.thenAccept(v -> {
                System.out.println(v);
            });*/

          // Thread.sleep(200);

           parseNumber4("1").thenAccept(v -> {
               System.out.println(v);

            }).thenApply( v -> parseNumber3("1"))
                   .thenApply( v -> parseNumber3("5"))
            .exceptionally(e -> {
                e.printStackTrace();
                System.out.println("Unhandled Exception in CF " + e.getMessage());
                return null;
            });

           parseNumber4("5")
                   .thenCompose(v -> parseNumber4(String.valueOf(v)))
                   .thenCompose(v -> parseNumber4(String.valueOf(v)))
                   .whenComplete( (v , ex) -> {
                       System.out.println(v);
                       ex.printStackTrace();
                   });


        }catch (Exception e){
            System.out.println("Exception in main : " + e.getMessage());
        }


    }

    private static CompletableFuture<Integer> parseNumber(String num){
        return CompletableFuture.supplyAsync(() -> {
                    int result = Integer.parseInt(num);
            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("done");
                    return result;
                 })
                .exceptionally(e -> {
                    System.out.println(e.getMessage());
                    return -1;
                });
    }

    private static CompletableFuture<Integer> parseNumber2(String num){
        return CompletableFuture.supplyAsync(() -> {
            int result = Integer.parseInt(num);
            return 100/result;
        })
        .exceptionally(e -> {
            System.out.println(e);
            if (e.getCause() instanceof NumberFormatException) {
                System.out.println(e.getMessage());
                return -1;
            }
            throw new RuntimeException(e);
        });
    }


    private static Integer parseNumber3(String num) {
        try {
            int result = Integer.parseInt(num);
            System.out.println("parseNumber3");
            return 100 / result;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static CompletableFuture<Integer> parseNumber4(String num) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("parseNumber4");
            int result = Integer.parseInt(num);
            return 100/result;
        });
    }
}

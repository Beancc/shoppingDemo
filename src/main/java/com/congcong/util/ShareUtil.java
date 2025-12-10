package com.congcong.util;

import java.util.Scanner;

/**
 * @ClassName ShareUtil
 * @Description
 * @Author wangcong
 * @Date 2025/10/9 13:37
 * @Version 1.0
 */
public class ShareUtil {
    public static void main(String[] args) {
        while (true) {
            //当前总股数
            Integer currentShares = 0;
            //当前一股实时价格
            Double currentPrice = 0d;
            //当前一股成本
            Double currentCost = 0d;
            //当前卖出股份
            Integer saleShares = 0;
            //卖出后单股成本价
            Double finalCost = 0d;
            //卖出后剩余股数
            Integer finalShares = 0;

            System.out.println("====================计算器开始====================");
            System.out.println("请输入数字选择你需要计算的内容：");
            System.out.println("1：输入卖出数，计算卖出后的持仓成本。");
            System.out.println("2：输入期望最终成本价，计算需要卖出的股数。");
            Scanner model = new Scanner(System.in);
            String modelNext = model.next();
            if(!modelNext.equals("1") && !modelNext.equals("2")) {
                System.out.println("输入错误！请输入正确的序号");
                continue;
            }
            //基础信息
            System.out.println("请输入当前总股数：");
            while(true) {
                Scanner totalSharesScanner = new Scanner(System.in);
                currentShares = totalSharesScanner.nextInt();
                if(currentShares != 0 &&  currentShares % 100 == 0) {
                    break;
                }
                System.out.println("请正确输入总股数，应该是大于0的100的整数倍！");
            }
            System.out.println("请输入当前一股实时价格：");
            Scanner currentPriceScanner = new Scanner(System.in);
            currentPrice = currentPriceScanner.nextDouble();
            System.out.println("请输入当前一股成本价格：");
            Scanner currentCostScanner = new Scanner(System.in);
            currentCost = currentCostScanner.nextDouble();

            if(modelNext.equals("1")) {
                System.out.println("请输入想要卖出的股数：");
                while (true) {
                    Scanner saleSharesScanner = new Scanner(System.in);
                    saleShares = saleSharesScanner.nextInt();
                    if(saleShares > 0 &&  saleShares % 100 == 0 && saleShares <= currentShares) {
                        break;
                    }
                    System.out.println("请正确输入想要卖出的股数，应该是小于等于持股数且大于0的100的整数倍！");
                }
                finalShares = currentShares - saleShares;
                finalCost = ((currentCost * currentShares)-(saleShares * currentPrice))/(currentShares-saleShares);
                System.out.println("==========卖出"+ saleShares +"股以后还剩"+ finalShares +"股，剩余每股成本为"+finalCost+"==========");
            }else {
                while (true) {
                    System.out.println("请输入想要达到的最终成本价：");
                    Scanner finalCostScanner = new Scanner(System.in);
                    finalCost = finalCostScanner.nextDouble();
                    if(finalCost >= 0 &&  finalCost < currentPrice) {
                        break;
                    }
                    System.out.println("请正确输入想要的最终成本价，应该是大于等于0且小于当前成本价！");
                }
                double v = ((currentCost * currentShares) -(finalCost * currentShares)) / (currentPrice - finalCost);
                saleShares = ((int) (v / 100) + 1) * 100;
                System.out.println("==========卖出"+ saleShares +"股以后（向上取整）可以将剩余股票的成本价做到"+ finalCost +"以下==========");
            }

            System.out.println("====================计算器结束====================");
            System.out.println("是否需要继续计算？按Y继续计算，其他任意键退出。");
            Scanner finishScanner =  new Scanner(System.in);
            if(!finishScanner.next().equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}

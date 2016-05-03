package com.router;

import com.router.service.RouterService;

/**
 * Created by daoshibushi on 2016/4/29.
 */
public class RouterServiceTest {

    public static void main(String argvs[]){

        RouterService routerService=new RouterService();

        String pathString=routerService.getPath();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("----------这是我的路线--------->"+pathString);
    }
}

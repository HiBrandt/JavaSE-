package com.project.java.project_02;

public class CustomerView {

    //CustomerList对象
    //所有的增删改查都是在对customers操作的，独一份。所以都能记录
    private CustomerList customers = new CustomerList(10);

    public static void main(String[] args) {
        CustomerView view=new CustomerView();
        view.enterMainMenu();
    }

    //显示主菜单，响应用户输入，根据用户输入调用其他方法
    public void enterMainMenu(){
        // 是静态的方法直接调用就可以
        //CMUtility util=new CMUtility();
        boolean flag=true;
        while(flag){
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");
            //静态方法直接调用
            char c = CMUtility.readMenuSelection();
            switch (c){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        flag=false;
                    }
                    break;

            }


        }

    }

    /**
     *添加客户
     */
    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        Customer customer=new Customer();
        System.out.print("姓名:");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);
        customer.setName(name);
        customer.setGender(gender);
        customer.setAge(age);
        customer.setPhone(phone);
        customer.setEmail(email);
        boolean isaddCustomer = customers.addCustomer(customer);
        //返回值的判断
        if(isaddCustomer==true){
            System.out.println("---------------------添加完成---------------------");
        }else {
            System.out.println("----------------记录已满,无法添加-----------------");
        }

    }

    /**
     *修改客户信息
     */
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        //修改对象是对已经有的对象进行修改 不用重新new？？
       // Customer customer=new Customer();
        System.out.print("请选择待修改客户编号(-1退出)：");
        int index = CMUtility.readInt();
        //没有输入对就一直让你输入
        boolean  a=true;
        while (a){
            if(index==-1){
                return;
            }
            if(index>=0 && index<=customers.getTotal()){
                //找到要修改的对象
                Customer indexcustomer = customers.getCustomer(index-1);
                System.out.print("姓名:");
                String name = CMUtility.readString(4);
                System.out.print("性别：");
                char gender = CMUtility.readChar();
                System.out.print("年龄：");
                int age = CMUtility.readInt();
                System.out.print("电话：");
                String phone = CMUtility.readString(15);
                System.out.print("邮箱：");
                String email = CMUtility.readString(15);
                indexcustomer.setName(name);
                indexcustomer.setGender(gender);
                indexcustomer.setAge(age);
                indexcustomer.setPhone(phone);
                indexcustomer.setEmail(email);
                boolean b = customers.replaceCustomer(index, indexcustomer);
                if(b==true){
                    System.out.println("---------------------修改完成---------------------");
                    a=false;
                }else {
                    System.out.println("无法找到指定客户！");
                }
            }else {
                System.out.println("无法找到指定客户！");
                return;
            }
        }





    }

    /**
     *删除客户信息
     */
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        System.out.print("请选择待修改客户编号(-1退出)：");
        int index = CMUtility.readInt();
        boolean  a=true;
        while (a){
            if(index==-1){
                return;
            }
            if(index>=0 && index<=customers.getTotal()){
                System.out.print("确认是否删除(Y/N)：");
                char yn = CMUtility.readConfirmSelection();
                if(yn=='Y'){
                    boolean b = customers.deleteCustomer(index-1);
                    if(b==true){
                        System.out.println("删除成功！");
                        a=false;
                    }else {
                        System.out.println("无法找到指定客户！");
                        a=false;
                    }
                }else {
                    return;
                }
            }else {
                System.out.println("无法找到指定客户！");
                return;
            }
        }


    }

    /**
     * 返回客户列表
     */
    private void listAllCustomers(){

        System.out.println("---------------------------客户列表---------------------------");
        //体会这种方法之间的套用
        int total = customers.getTotal();
        if(total==0){
            System.out.println("暂无客户信息");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            //所有客户信息的数组 allCustomer
            //ps:getAllCustomer()要获取的是添加后的total个数的数组，不是初始化的CustomerList的个数，不然可能就是空指针
            Customer[] allCustomer = customers.getAllCustomer();
            for(int i=0;i<allCustomer.length;i++){
                System.out.println(i + 1 + "\t" + allCustomer[i].getName() +
                        "\t" + allCustomer[i].getGender() + "\t" + allCustomer[i].getAge() +
                        "\t\t" + allCustomer[i].getPhone() + "\t\t" + allCustomer[i].getEmail());
            }
            System.out.println("-------------------------客户列表完成-------------------------");
        }

    }
}

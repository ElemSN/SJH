#include <iostream>
//修饰模式  调用方式先调用自己等fun（）函数，后转移到父类的fun（）方法，类似于递归 
using namespace std;
class Base{
	private:
		Base *next;
	public:
		Base(Base *t)
		{
			next=t;
		}
		virtual void fun(){
			if(next!=NULL)
			next->fun();
		} 
		~Base(){//从子类反上来的析构调用（先调用子类后调用父类） 
			cout<<"调用析构函数"<<endl; 
			if(next!=NULL)
			delete next;//回收下一个空间 
		}
};
class ProductA:public Base{
	public:
		ProductA(Base *t):Base(t){
		}
		void fun()
		{
			cout<<"ProductA"<<endl;
			Base::fun();//调用父类fun函数 
		}
};
class Decorator:public Base{
	public:
		Decorator(Base *t):Base(t){
		}
		virtual void fun()=0;//与父类保持一致 
};
class DecoratorA:public Decorator{
	public:
	DecoratorA(Base *t):Decorator(t){
	}
	void fun(){
		cout<<"DecoratorA"<<endl;
		Base::fun();
	}
};
class DecoratorB:public Decorator{
	public:
	DecoratorB(Base *t):Decorator(t){
	}
	void fun(){
		cout<<"DecoratorB"<<endl;
		Base::fun();
	}
};
int main(){
	Base *head=new DecoratorB(NULL);//与数据结构头插法创建类似 
	head=new DecoratorA(head);
	head=new ProductA(head);
	head->fun();
	delete head;//垃圾回收  
}

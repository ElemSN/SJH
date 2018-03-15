#include <iostream>
//����ģʽ  ���÷�ʽ�ȵ����Լ���fun������������ת�Ƶ������fun���������������ڵݹ� 
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
		~Base(){//�����෴�������������ã��ȵ����������ø��ࣩ 
			cout<<"������������"<<endl; 
			if(next!=NULL)
			delete next;//������һ���ռ� 
		}
};
class ProductA:public Base{
	public:
		ProductA(Base *t):Base(t){
		}
		void fun()
		{
			cout<<"ProductA"<<endl;
			Base::fun();//���ø���fun���� 
		}
};
class Decorator:public Base{
	public:
		Decorator(Base *t):Base(t){
		}
		virtual void fun()=0;//�븸�ౣ��һ�� 
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
	Base *head=new DecoratorB(NULL);//�����ݽṹͷ�巨�������� 
	head=new DecoratorA(head);
	head=new ProductA(head);
	head->fun();
	delete head;//��������  
}

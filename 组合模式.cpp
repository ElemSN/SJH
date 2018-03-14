#include<iostream>
#include<vector>
using namespace std;
class AbstractFile{
	protected:
		string name;
	public:
		AbstractFile()
		{
			name="未命名";
		}
		AbstractFile(string s)
		{
			name=s;
		}
		virtual void out()=0;
}; 
class File:public AbstractFile{
	public:
		File()
		{
			name="未命名文件";
		} 
		File(string s):AbstractFile(s)
		{} 
		void out()
		{
			cout<<"File:"<<name<<endl;
		}
};
class Folder:public AbstractFile{
	private:
		vector<AbstractFile*> vec;
		public:
			Folder()
			{
				name="未命名文件夹";
			}
			Folder(string s): AbstractFile(s)
			{}
			void add(AbstractFile *Ab)
			{
				vec.push_back(Ab);
			}
			void out()
			{
				vector<AbstractFile *>::iterator it;
				cout<<"Folder:"<<name<<endl;
				for(it=vec.begin();it!=vec.end();it++)
				{  
					(*it)->out();
				}
			}
};

int main ()
{
	Folder *root=new Folder("F:\\");
	File *a1=new File("1.txt");
	File *a2=new File("2.txt");
	File *b1=new File("11.txt");
	File *b2=new File("22.txt");
	Folder *root1=new Folder("a:\\");
	root->add(a1);
	root->add(a2);
	root->add(root1);
	root1->add(b1);
	root1->add(b2);
	root->out();
}

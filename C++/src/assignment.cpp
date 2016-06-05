#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;
class BinaryTreeNode;
static BinaryTreeNode *entryNode = NULL;


class Hash {

	private:
		int hashSize;
		vector<vector <vector<int> > > hashTable;

	public:
	Hash(){
	}

	void setHashSize(int hashSize){
		this->hashSize = hashSize;
		int i = 0;
		//-2 is the case which is just for
		//allocation
		vector< vector <int> > temp;
		vector<int> temp1;
		temp1.push_back(-2);
		temp1.push_back(-2);
		temp1.push_back(-2);
		temp.push_back(temp1);
		for(i =0 ; i < hashSize; i++)
		{
			hashTable.push_back(temp);
		}
	}
	Hash(int hashSize){
		hashSize = hashSize;
	}



		vector<vector <vector<int> > >  getHashTable(){

	return	hashTable;
	}

	~Hash(){
		//Go throught the hash release all the
		//memebers for memory
	}

	int hashFunc(vector<int> triplet){
		return triplet[0]%hashSize;
	}

	void insert(vector<int> triplet ){
		int index = hashFunc(triplet);
		vector<vector<int> > temp1;
		temp1= hashTable[index];
		if(temp1.size() == 1 && temp1[0][0] == -2)
        {
            temp1.pop_back();
        }
		temp1.push_back(triplet);
		hashTable[index] = temp1;
	}

	void printHash(){

		vector< vector<int> > temp;
		vector<int> temp1;
		for (vector< vector<vector<int> > >::iterator it = hashTable.begin() ; it != hashTable.end(); ++it)
		{
			temp = *it;
			for(vector<vector<int> >::iterator it1 = temp.begin(); it1 != temp.end(); ++it1)
			{
				temp1 = *it1;
				cout<<"Size of the hash is "<<temp1.size()<<endl;
				for(vector<int>::iterator it2 = temp1.begin();it2 != temp1.end();++it2)
				{
					cout << ":"<< *it2 << endl;
				}

			}
		}

		//for(vector<vector<int> >::iterator it1 = *it.begin();it1 != *it.end(); ++it1)
		//for (std::vector<int>::iterator it1 = *it.begin() ; it1 != *it.end(); ++(*it))
		//std::cout << ' ' << *it;
		std::cout << '\n';
	}

};


class BinaryTreeNode {
	public:
	/* node ID*/
	int nodeID;

	/*left child */
	BinaryTreeNode *leftChild;

	/*right child */
	BinaryTreeNode *rightChild;

	BinaryTreeNode(int nodeID){
        nodeID = nodeID;
	}

	~BinaryTreeNode(){
        cout<<"Calling destructor"<<endl;
	}
};

class BinaryTree{
	private:
		BinaryTreeNode *root;
	public:
		BinaryTree(){
			root = NULL;
			cout<<"Constructor called of BinaryTree"<<endl;
		}
		~BinaryTree(){

		}
		void insert(BinaryTreeNode *rootNode, int val)
		{
			if(root == NULL)
			{
				rootNode = new BinaryTreeNode(val);
				rootNode->leftChild = NULL;
				rootNode->rightChild = NULL;
				rootNode->nodeID = val;
				root = rootNode;
			}else if(rootNode == NULL)
                        {
                                rootNode = new BinaryTreeNode(val);
                                rootNode->leftChild = NULL;
                                rootNode->rightChild = NULL;
                                rootNode->nodeID = val;
                        }else if(val < root->nodeID){
				insert(rootNode->leftChild, val);
			}else{
				insert(rootNode->rightChild, val);
			}
		}

		void postOrder(BinaryTreeNode *root){
			if(root == NULL){
				cout<<"Finished"<<endl;
				return;
			}else{
				cout<<root->nodeID;
			}
			postOrder(root->leftChild);
			postOrder(root->rightChild);
		}


		void  construct(Hash *hash, BinaryTreeNode* root){
			vector<vector <vector<int> > > hashTable = hash->getHashTable();
			vector< vector<int> > temp;
			vector<int> temp1;
			for (vector< vector<vector<int> > >::iterator it = hashTable.begin() ; it != hashTable.end(); ++it)
			{
				temp = *it;
				for(vector<vector<int> >::iterator it1 = temp.begin(); it1 != temp.end(); ++it1)
				{
					temp1 = *it1;
					for(vector<int>::iterator it2 = temp1.begin();it2 != temp1.end();++it2)
					{
						insert(entryNode,*it2);
					}

				}
			}
            postOrder(root);

		}


};


int main(int argc, char *argv[]){
	cout<<"-----------------------------------\n";
	cout<<"Spring 2016------------------------\n";
	cout<<"CSCI36200: Programming Assignment 3\n";
	cout<<"-----------------------------------\n";
	if(argc != 2){
		//It needs inputfile.txt as an argument
		cout<<"USAGE: "<<argv[0] <<" input_file.txt\n";
		return 0;
	}else{

		vector <vector<int> > tripletsList;

		FILE *fp = fopen (argv[1], "r");

		//This the placeholder to read the input
		//initialization will be done on getting the input
		int no_of_triplets;
		int hash_size;

		Hash h;
		//Start reading the file
		//	string line;
		int i = 0;
		while(1){
			if(i == 0){
				//Just read the number of triplets and the size of HASH
				if(fscanf( fp, "%d %d", &no_of_triplets, &hash_size ) == EOF){
					fclose(fp);
					break;
				}
				h.setHashSize(hash_size);
			}else{
				int root;
				int lchild;
				int rchild;
				vector <int> temp;
				if(fscanf(fp, "%d %d %d ", &root, &lchild, &rchild) == EOF){
					fclose(fp);
					break;
				}
				temp.push_back(root);
				temp.push_back(lchild);
				temp.push_back(rchild);
				cout<<"The vector temp is"<<temp[0]<<":"<<temp[1]<<":"<<temp[2]<<"\n";
				tripletsList.push_back(temp);
				h.insert(temp);
			}
			i++;
		}

		BinaryTree tree;
		tree.construct(&h,entryNode);
		//h.printHash();
	}
	return 0;
}

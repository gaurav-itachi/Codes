#include<vector>
#include <iostream>
using namespace std;

vector<int> cur_pos,min_pos,max_pos,pos_to_post;

void like_post(int post_no){
	if(post_no<=0 || post_no>cur_pos.size()){
		return ;
	}
int cur_pos_of_liked_post = cur_pos[post_no];

	if(cur_pos_of_liked_post == 1) {
return;
}
int other_affected_post = pos_to_post[cur_pos_of_liked_post - 1 ] ;

int updated_pos_for_liked_pos = 
cur_pos[post_no] -- ;
cur_pos[other_affected_post] ++;
min_pos[post_no] = min(cur_pos[post_no],min_pos[post_no]);
max_pos[other_affected_post] = max(cur_pos[other_affected_post],max_pos[other_affected_post] );
pos_to_post[cur_pos[post_no]]  = post_no;
pos_to_post[cur_pos[other_affected_post] ] = other_affected_post; 
}

int main(){
    int n,m;
    cin>>n>>m;
    cur_pos.resize(n+1);
	min_pos.resize(n+1);
	max_pos.resize(n+1);
	pos_to_post.resize(n+1);
	for(int i=1; i<=n; ++i){
		cur_pos[i]=i;
		min_pos[i]=i;
		max_pos[i]=i;
		pos_to_post[i]=i;
	}
	for(int i=0;i<m;++i){
int post_liked;
cin>>post_liked;
		like_post(post_liked);
}
for(int i=1;i<=n;++i){
	cout<<min_pos[i]<<" "<<max_pos[i]<<endl;
}
    return 0;
}

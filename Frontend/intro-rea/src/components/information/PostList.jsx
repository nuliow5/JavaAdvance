import React from 'react';
import CardExample from "./CardExample";


const PostList = ({posts}) => {
    return (
        <div>
            <div className={"pets_content"}>
                {posts.map(post =>
                    <CardExample post={post} />
                )}
            </div>
        </div>
    );
};

export default PostList;
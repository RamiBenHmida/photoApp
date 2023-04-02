import { User } from "./user";

export class Photo {
    id! : number;
    nbOfLikes! : number;
    imageUrl!: String;
    user!:User;
    likeStatus!: boolean;
}
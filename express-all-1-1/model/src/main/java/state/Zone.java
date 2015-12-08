package state;

public enum Zone {
	PLANE,CAR,TRAIN,EMPTY,NULL;
	//EMPTY指机动仓库，NULL指向空（主要是库存报警这个用例里面可能会返回这个值，表示没有仓库库存报警）
}

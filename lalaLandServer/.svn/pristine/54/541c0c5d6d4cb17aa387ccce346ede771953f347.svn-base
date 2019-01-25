package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import service.AttendServiceImpl;
import service.BoardServiceImpl;
import service.CouponServiceImpl;
import service.EventJoinServiceImpl;
import service.EventServiceImpl;
import service.IAttendService;
import service.IBoardService;
import service.ICouponService;
import service.IEventJoinService;
import service.IEventService;
import service.ILalaLandBuyService;
import service.ILalaLandFoodService;
import service.ILalaLandItemService;
import service.ILalaLandMemberService;
import service.IReserveService;
import service.IRideService;
import service.IZooService;
import service.LalaLandBuyServiceImpl;
import service.LalaLandFoodServiceImpl;
import service.LalaLandItemServiceImpl;
import service.LalaLandMemberServiceImpl;
import service.ReserveServiceImpl;
import service.RideServiceImpl;
import service.ZooServiceImpl;

public class LalaLandMain {
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1088);
			IBoardService boardService = BoardServiceImpl.getInstance();
			ILalaLandFoodService foodService = LalaLandFoodServiceImpl.getInstance();
			ILalaLandItemService itemService = LalaLandItemServiceImpl.getInstance();
			ILalaLandMemberService memberService = LalaLandMemberServiceImpl.getInstance();
			IRideService ride = RideServiceImpl.getInstance();
			IZooService zoo = ZooServiceImpl.getInstance();
			IReserveService reserve = ReserveServiceImpl.getInstance();
			ILalaLandBuyService buyService=new LalaLandBuyServiceImpl();	
			IEventService eventService = EventServiceImpl.getInstance();
			IAttendService attendService = AttendServiceImpl.getInstance();
			IEventJoinService eventJoinService = EventJoinServiceImpl.getInstance();
			ICouponService couponService = CouponServiceImpl.getInstance();
			
			reg.rebind("boardService",boardService);
			reg.rebind("foodService",foodService);
			reg.rebind("itemService",itemService);
			reg.rebind("memberService",memberService);
			reg.rebind("ride",ride);
			reg.rebind("zoo",zoo);
			reg.rebind("reserve",reserve);
			reg.rebind("buy",buyService);
			reg.rebind("eventService",eventService);
			reg.rebind("attendService",attendService);
			reg.rebind("eventJoinService", eventJoinService);
			reg.rebind("couponService", couponService);
			
			System.out.println("서버 준비 완료");
		} catch (RemoteException e) {
			e.printStackTrace();
		}


	}

}

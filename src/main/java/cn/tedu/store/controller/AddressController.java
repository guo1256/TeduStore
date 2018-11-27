package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Resource
	private IAddressService addressService;
	
	//显示地址管理页面
	@RequestMapping("/showAddress.do")
	public String showAddress() {
		return "addressAdmin";
	}
	
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(	
			HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Void> rr =
				new ResponseResult<Void>(1,"成功");
		Address address = new Address();
		address.setUid(this.getId(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);		
		return rr;	
	}
	
	@RequestMapping("/getByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getByUid(HttpSession session){
		ResponseResult<List<Address>> rr =
				new ResponseResult<List<Address>>(1,"成功");
		List<Address> list = addressService.getByUid(this.getId(session));
		rr.setData(list);
		return rr;
	}
	
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session,Integer id){
		ResponseResult<Void> rr = null;
		try {
			addressService.setDefault(this.getId(session), id);
			rr = new ResponseResult<Void>(1,"设置成功");
		} catch (RuntimeException ex) {
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	//异步请求，通过id查询地址信息
	@RequestMapping("/goUpdate.do")
	@ResponseBody
	public ResponseResult<Address> goUpdate(Integer id){
		//创建rr对象
		ResponseResult<Address> rr =
				new ResponseResult<Address>(1,"成功");
		//调用业务层方法 返回Address对象
		Address address = addressService.getById(id);
		//把Address对象添加到rr对象中
		rr.setData(address);
		return rr;
	}
	
	//异步请求，修改收货人地址信息
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Void> updateAddress(
			Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag
			){
		ResponseResult<Void> rr =
				new ResponseResult<Void>(1,"成功");
		Address address = new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.updateAddress(address);
		return rr;
	}
	
	//通过id删除地址
	@RequestMapping("/removeAddress.do")
	@ResponseBody
	public ResponseResult<Void> removeAddress(Integer id){
		//创建rr对象
		ResponseResult<Void> rr =
				new ResponseResult<Void>(1,"成功");
		addressService.removeAddress(id);
		return rr;
	}
}

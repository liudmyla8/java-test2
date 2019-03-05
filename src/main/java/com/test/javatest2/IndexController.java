package com.test.javatest2;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.test.javatest2.Transaction;
import com.test.javatest2.TransactionRepository;

@Controller
@RequestMapping
public class IndexController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	protected static int total;
	protected static List<String> cash;
	protected static String endCash;

    @GetMapping ("/")
    public void getForm(Model model) {
		Transaction tr = new Transaction();
		model.addAttribute(tr);
    }
    
    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public @ResponseBody String giveCash(@ModelAttribute Transaction tr) {

		total = tr.getSum();
    	cash = CurrencyController.SelectCurrency(JavaTest2Application.currency, total);

		if(cash != null) {
			endCash = total + " = ";
			for(int i = 0; i < cash.size(); i++) {
				if(i != cash.size()-1) {
					endCash += cash.get(i) + " + ";
				} else {
					endCash += cash.get(i);
				}
			}
		}else{
			endCash = "Have no currency for your query.";
		}

		Date d = new Date();
		tr.setDate(d);
		transactionRepository.save(tr);
		return endCash;
    }
    
    @GetMapping("/all")
	public @ResponseBody Iterable<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

}

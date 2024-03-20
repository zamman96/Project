package blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Deck {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.process();
	}
	
	public void process() {
		Card[] cardList = cardList();
//		System.out.println("===============초기 카드===========");
//		print(cardList);
	
		cardList = shuffle(cardList);
//		System.out.println("===============섞은 카드===========");
//		print(cardList);
	
//		 카드 섞은 후 첫번째 카드
		
		ArrayList <Card> myCard = new ArrayList<>();
		ArrayList <Card> dealerCard = new ArrayList<>();
		// 딜러는 내가 뽑을 떄 1장 뽑는다
		int mysum = 0;
		int dealsum = 0;
		int cur = 0;
		while(true) {
			if(mysum<21&&dealsum<21) {
			System.out.println("나의카드 총합 : "+mysum);
			System.out.println("딜러카드 총합 : "+dealsum);
			System.out.println("카드를 뽑겠습니까?");
			System.out.println("1. 진행");
			System.out.println("2. 끝낸다");
			int sel = sc.nextInt();
			if(sel==1) {
				System.out.println("뽑은 카드 : "+cardList[cur]);
				mysum+=cardList[cur].num;	
				myCard.add(cardList[cur]);
				cur++;
				// 딜러는 16점 이하일 때 카드를 더 뽑는다
				if(dealsum<=16) {
				System.out.println("딜러가 뽑은 카드 : "+cardList[cur]);
				dealsum+=cardList[cur].num;	
				dealerCard.add(cardList[cur]);
				cur++;
				}
			} else if(sel==2) {
				while(dealsum<=16) {
					if(dealsum<=16) {
				System.out.println("딜러가 뽑은 카드 : "+cardList[cur]);
				dealsum+=cardList[cur].num;	
				dealerCard.add(cardList[cur]);
				cur++;
				System.out.println("========딜러 카드 목록========");
				for(int i=0; i<dealerCard.size();i++){
					System.out.print(dealerCard.get(i)+"\t");
				}
				System.out.println("\n총합 : "+ dealsum);
				System.out.println("==========================");
					} else {break;}
				}
				break;}
			} else if(mysum>=21&&dealsum<21) {
				break;
			} else if(dealsum>=21) {
				break;
			}
		
		
		System.out.println("========나의 카드 목록========");
		for(int i=0; i<myCard.size();i++) {
		System.out.print(myCard.get(i)+"\t");
		}
		
		System.out.println("\n총합 : "+ mysum);
		
	
		System.out.println("========딜러 카드 목록========");
		for(int i=0; i<dealerCard.size();i++){
			System.out.print(dealerCard.get(i)+"\t");
		}
		System.out.println("\n총합 : "+ dealsum);
		System.out.println("==========================");
		}
	
		if(mysum>=21) {
			System.out.println("당신 카드의 총합이 21을 넘겼습니다.");
			System.out.println("졌습니다");
		} else if (dealsum>=21){
			System.out.println("딜러의 카드의 총합이 21을 넘겼습니다.");
			System.out.println("이겼습니다");			
		} else if (mysum==dealsum) {
			System.out.println("비겼습니다.");
		} else if (mysum>dealsum) {
			System.out.println("이겼습니다.");
		} else {
			System.out.println("졌습니다.");
		}
			
		}
	
//		// 컴퓨터 카드 랜덤으로 뽑기
//		public Card comCard(Card[] cardList) {
//			int ran = new Random().nextInt(52);
//			return cardList[ran];
//		}
	
	
	
	
	
	//카드 공개
	public void print(Card[] cardList) {
		for (int i=0; i<cardList.length ; i++) {
			if(i%13 ==0 && i!=0) {
				System.out.println();
			}
			System.out.print(cardList[i]+"\t");
		}
		System.out.println();
	}
	

	/*
	 *  카드 섞기
	 */
	public Card[] shuffle(Card[] cardList) {
		int temp = 0;
		String[] types = {"♠", "◆","♥","♣"};
			for (int i=0;i<cardList.length;i++) {
				int r = new Random().nextInt(cardList.length);
				temp=cardList[i].num;
				cardList[i].num=cardList[r].num;
				cardList[r].num=temp;
			}
		
		return cardList;
	}
	
	public Card[] cardList() {
		Card[] cardList = new Card[52];
		int cur =0;
		String[] types = {"♠", "◆","♥","♣"};
		for (String type : types) {
			for(int i=1; i<=13; i++) {
				Card card = new Card(i, type);
				cardList[cur++] = card; 
			}
		}
		return cardList;
	}
	
	
}
	

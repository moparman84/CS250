/**
 * 
 */
/**
 * @author JerimeyBurnside
 *
 module cs250 
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Detox and Wellness Destinations SlideShow"); // changed the title to define the type of destinations
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	// All images are provided by the different resort management
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/sha-wellness-clinic.jpg") + "'</body></html>";
			//Image updated to sha-wellnes-clinic to showcase the new destination 
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/garden-at-valley-rock.jpg") + "'</body></html>";
			//Image updated to garden-at-valley-rock to showcase the new destination 
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/amankora-paro-tiger-s.jpg") + "'</body></html>";
			//Image updated to amankora-paro-tiger-s to showcase the new destination 
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/meditation-classes.jpg") + "'</body></html>";
			//Image updated to meditation-classes to showcase the new destination 
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/ranch-at-live-oak-malibu.jpg") + "'</body></html>";
			//Image updated to ranch-at-live-oak-malibu to showcase the new destination 
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	// All of the top 5 destinations changed to those of detox and wellness. The descriptions were also changed to reflect and showcase the benefit of each.
	private String getTextDescription(int i) { 
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 SHA Detox in Spain.</font> <br>Expect lots of ancient Chinese medicinal therapy, as part of the renewal process.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Valley Rock Inn and Mountain Club in New York.</font> <br>A Place for either a leisure or hardcore fitness retreat.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Amankora in the Kingdom of Bhutan.</font> <br>Amankora is for both spiritual and physical transformation.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Kamalaya in Thailand.</font> <br>Focusing on lifestyle, and overall emotional wellbeing.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 The Ranch in Malibu, CA.</font> <br> Let’s just say you’ll be moving more than sitting, but you’ll sleep like a baby.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}
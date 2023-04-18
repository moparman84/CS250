import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
            	// This changes the background color to specified color in this case Yellow            	
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 1050); // Changed the initial window size to show all information on page and not have to side scroll

        listModel = new DefaultListModel();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        // All images were collected from https://commons.wikimedia.org with photographer names and titles included in the file name
        // All destination descriptions were my original thought after looking at the photos
        // changed the listing to show case Rome as the number one destination. Photo is credited to Mehrshiddoroudian 
        addDestinationNameAndPicture("1. Rome, Italy (Perfect destinations for any art lover.)", new ImageIcon(getClass().getResource("/resources/640px-Rome_italy_0041_Credit_to_Mehrshiddoroudian.jpg")));
        // changed the listing to show case Sidney as the number two destination. Photo is credited to  Ben Avenling
        addDestinationNameAndPicture("2. Sidney, Australia (A destination with scenery that will enchant the senses)", new ImageIcon(getClass().getResource("/resources/Sydney_Opera_House_credit_to_BenAvenling.jpg")));
        // changed the listing to show case Dublin as the third top destination. Photo is credited to Christine Matthewas
        addDestinationNameAndPicture("3. Dublin, Ireland (Where classic traditions treat you to new experiances)", new ImageIcon(getClass().getResource("/resources/Dublin_Ireland_credit_to_Christine_Matthews.jpg")));
        // changed the listing to show case Rio as the fourth top destination. Photo is credited to Donatas Dabravolskas
        addDestinationNameAndPicture("4. Rio de Janeiro, Brazil (A place where beauty take on a new meaning)", new ImageIcon(getClass().getResource("/resources/Rio_de_Janeiro_Credit_to_Donatas_Dabravolskas.jpg")));
        // changed the listing to show case British Virgin Islands as the fifth top destination. Photo is credited to Peter Dutton
        addDestinationNameAndPicture("5. British Virgin Islands (The place where all the problems of the world jsut disappear)", new ImageIcon(getClass().getResource("/resources/Buck_Island_(British_Virgin_Islands)_credit_to_Peter_Dutton.jpg")));
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);
        // This changes the background color to specified color in this case Yellow
        list.setBackground(Color.YELLOW);
        
        list.setCellRenderer(renderer);
        
        // Creating a new JLabel that will constructs my name at the top of the JFrame.
     	// using BorderLayout.North is how the placement is achieved 
     	JLabel lblNewLabel = new JLabel("Jerimey Burnside");
     	getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {        	
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}
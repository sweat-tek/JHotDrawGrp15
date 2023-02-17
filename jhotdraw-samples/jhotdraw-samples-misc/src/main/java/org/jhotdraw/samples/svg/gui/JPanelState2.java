package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.api.app.Disposable;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.event.FigureAttributeEditorHandler;
import org.jhotdraw.draw.event.SelectionComponentRepainter;
import org.jhotdraw.draw.gui.JAttributeSlider;
import org.jhotdraw.draw.gui.JAttributeTextField;
import org.jhotdraw.formatter.JavaNumberFormatter;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.action.ButtonFactory;
import org.jhotdraw.gui.plaf.palette.PaletteButtonUI;
import org.jhotdraw.gui.plaf.palette.PaletteColorChooserUI;
import org.jhotdraw.gui.plaf.palette.PaletteFormattedTextFieldUI;
import org.jhotdraw.gui.plaf.palette.PaletteSliderUI;
import org.jhotdraw.text.ColorFormatter;
import org.jhotdraw.util.Images;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.SliderUI;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static javax.swing.SwingConstants.SOUTH_EAST;
import static org.jhotdraw.draw.AttributeKeys.FILL_COLOR;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_GRADIENT;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_OPACITY;

public class JPanelState2 extends Panel{
    private static final String LABELSSTRING = "org.jhotdraw.samples.svg.Labels";
    public JPanelState2() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle(LABELSSTRING);
        Map<AttributeKey<?>, Object> defaultAttributes = new HashMap<>();
    }
    @Override
    public JPanel getPanelState(DrawingEditor editor, LinkedList<Disposable> disposables) {
        JPanel p = null;
        p = new JPanel();
        p.setOpaque(false);
        if (editor == null) {
            return p;
        }
        JPanel p1 = new JPanel(new GridBagLayout());
        JPanel p2 = new JPanel(new GridBagLayout());
        JPanel p3 = new JPanel(new GridBagLayout());
        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p.setBorder(new EmptyBorder(5, 5, 5, 8));
        p.removeAll();
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle(LABELSSTRING);
        GridBagLayout layout = new GridBagLayout();
        p.setLayout(layout);
        // Fill color field and button
        Map<AttributeKey<?>, Object> defaultAttributes = new HashMap<>();
        FILL_GRADIENT.put(defaultAttributes, null);
        JAttributeTextField<Color> colorField = new JAttributeTextField<>();
        colorField.setColumns(7);
        colorField.setToolTipText(labels.getString("attribute.fillColor.toolTipText"));
        colorField.putClientProperty("Palette.Component.segmentPosition", "first");
        colorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(colorField));
        colorField.setFormatterFactory(ColorFormatter.createFormatterFactory(ColorFormatter.Format.RGB_INTEGER_SHORT, false, false));
        colorField.setHorizontalAlignment(JTextField.LEFT);
        disposables.add(new FigureAttributeEditorHandler<Color>(FILL_COLOR, defaultAttributes, colorField, editor, true));
        GridBagConstraints gbc;
        AbstractButton btn;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p1.add(colorField, gbc);
        btn = ButtonFactory.createSelectionColorChooserButton(editor,
                FILL_COLOR, "attribute.fillColor", labels,
                defaultAttributes, new Rectangle(3, 3, 10, 10), PaletteColorChooserUI.class, disposables);
        btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p1.add(btn, gbc);
        // Opacity field with slider
        JAttributeTextField<Double> opacityField = new JAttributeTextField<>();
        opacityField.setColumns(4);
        opacityField.setToolTipText(labels.getString("attribute.fillOpacity.toolTipText"));
        opacityField.putClientProperty("Palette.Component.segmentPosition", "first");
        opacityField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(opacityField));
        JavaNumberFormatter formatter = new JavaNumberFormatter(0d, 100d, 100d, false, "%");
        formatter.setUsesScientificNotation(false);
        formatter.setMaximumFractionDigits(1);
        opacityField.setFormatterFactory(new DefaultFormatterFactory(formatter));
        opacityField.setHorizontalAlignment(JTextField.LEFT);
        disposables.add(new FigureAttributeEditorHandler<Double>(FILL_OPACITY, opacityField, editor));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(3, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p2.add(opacityField, gbc);
        JPopupButton opacityPopupButton;
        JAttributeSlider opacitySlider;
        opacityPopupButton = new JPopupButton();
        opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
        opacityPopupButton.add(opacitySlider);
        labels.configureToolBarButton(opacityPopupButton, "attribute.fillOpacity");
        opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
        opacityPopupButton.setPopupAnchor(SOUTH_EAST);
        opacityPopupButton.setIcon(
                new SelectionOpacityIcon(editor, FILL_OPACITY, FILL_COLOR, null, Images.createImage(getClass(), labels.getString("attribute.fillOpacity.largeIcon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
        opacityPopupButton.setPopupAnchor(SOUTH_EAST);
        disposables.add(new SelectionComponentRepainter(editor, opacityPopupButton));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weighty = 1f;
        gbc.insets = new Insets(3, 0, 0, 0);
        p2.add(opacityPopupButton, gbc);
        opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
        opacitySlider.setScaleFactor(100d);
        disposables.add(new FigureAttributeEditorHandler<Double>(FILL_OPACITY, opacitySlider, editor));
        // Add horizontal strips
        gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(p1, gbc);
        gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(p2, gbc);
        gbc = new GridBagConstraints();
        gbc.gridy = 2;
        gbc.weighty = 1f;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        p.add(p3, gbc);
        return p;
    }
}

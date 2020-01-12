package MODEL;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

public class TableUtils {

    public static void installCopyPasteHandler(TableView<?> table) {

        // Pone la tabla a la escucha
        table.setOnKeyPressed(new TableKeyEventHandler());

    }

    public static class TableKeyEventHandler implements EventHandler<KeyEvent> {

        KeyCodeCombination copyKeyCodeCompination = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_ANY);

        public void handle(final KeyEvent keyEvent) {

            if (copyKeyCodeCompination.match(keyEvent)) {

                if (keyEvent.getSource() instanceof TableView) {

                    // Llama la funcion para copiar el valor seleccionado al portapapeles
                    copySelectionToClipboard((TableView<?>) keyEvent.getSource());

                    System.out.println("Copiado al portapapeles");

                    // Cuando usamos el evento lo consume
                    keyEvent.consume();

                }

            }

        }

    }

    public static void copySelectionToClipboard(TableView<?> table) {

        StringBuilder clipboardString = new StringBuilder();

        ObservableList<TablePosition> positionList = table.getSelectionModel().getSelectedCells();

        int prevRow = -1;

        for (TablePosition position : positionList) {

            int row = position.getRow();
            int col = position.getColumn();

            Object cell = (Object) table.getColumns().get(col).getCellData(row);

            // null-check
            if (cell == null) {
                cell = "";
            }

            // determine whether we advance in a row (tab) or a column
            // (newline).
            if (prevRow == row) {

                clipboardString.append('\t');

            } else if (prevRow != -1) {

                clipboardString.append('\n');

            }

            // Crea el string de la celda
            String text = cell.toString();

            // copia el texto al string builder
            clipboardString.append(text);

            // recuerda el anterior
            prevRow = row;
        }

        // crea el contenido del portapapeles
        final ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putString(clipboardString.toString());

        // añade el texto al portapapeles
        Clipboard.getSystemClipboard().setContent(clipboardContent);
    }
}

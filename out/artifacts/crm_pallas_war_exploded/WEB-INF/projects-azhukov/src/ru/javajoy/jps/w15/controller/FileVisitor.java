package ru.javajoy.jps.w15.controller;

import ru.javajoy.jps.w15.model.OperationsEnum;
import ru.javajoy.jps.w15.util.MessageBoxUtils;
import ru.javajoy.jps.w15.util.StringUtils;
import ru.javajoy.jps.w15.view.MainPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Класс содержит методы копироввть/переместить/удалить/узнать размер
 *
 * @author Artem Zhukov
 */
public class FileVisitor extends SimpleFileVisitor<Path> {

    private MainPanel parent;
    private OperationsEnum operation;
    private Path pathFrom;
    private Path pathTo;

    public FileVisitor(OperationsEnum operation) {
        this.operation = operation;
    }

    public FileVisitor(Path pathFrom, Path pathTo, OperationsEnum operation) {
        this(operation);
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
    }

    public FileVisitor(File pathFrom, File pathTo, OperationsEnum operation, JPanel parent) {
        this(pathFrom.toPath(), pathTo.toPath(), operation);
        this.parent = (MainPanel) parent;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attributes) throws IOException {
        switch (operation) {
            case COPY:
            case MOVE:
                Path targetDirectory = pathTo.resolve(pathFrom.relativize(dir));
                try {
                    if (operation == OperationsEnum.COPY) {
                        Files.copy(dir, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
                    } else if (operation == OperationsEnum.MOVE) {
                        Files.move(dir, targetDirectory);
                    }
                } catch (FileAlreadyExistsException e) {
                    if (!Files.isDirectory(targetDirectory)) {
                        throw e;
                    }
                }
                break;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        switch (operation) {
            case DELETE:
                try {
                    Files.delete(file);
                } catch (NoSuchFileException e) {
                    MessageBoxUtils.showFileNotFoundDialog();
                } catch (DirectoryNotEmptyException e1) {
                    MessageBoxUtils.showMessageDialog("Directory is not empty!");
                }
                MessageBoxUtils.showActionCompleteMessage();
                break;

            case COPY:
         //   case MOVE:
                Path targetDirectory = pathTo.resolve(pathFrom.relativize(file));
                try {
                    if (operation == OperationsEnum.COPY) {
                        Files.copy(file, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
                    } else if (operation == OperationsEnum.MOVE) {
                        Files.move(file, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch (FileAlreadyExistsException e) {
                    if (!Files.isDirectory(targetDirectory)) {
                        throw e;
                    }
                }
                break;

            case SIZE:
                /* This is only defines a size of files, not directories. */
                if (!StringUtils.isNullOrEmpty(pathFrom.toString()) && Files.exists(pathFrom)) {
                    String message = "Size of file is " + String.valueOf(Files.size(pathFrom)) + " byte(s)";
                    parent.setInfo(message);
                } else {
                    MessageBoxUtils.showFileNotFoundDialog();
                }
                break;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir,
                                              IOException exc) throws IOException {
        switch (operation) {
            case DELETE:
                if (exc == null) {
                    Files.delete(dir);
                } else {
                    throw exc;
                }
                break;
        }
        return FileVisitResult.CONTINUE;
    }

}
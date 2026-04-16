package com.kaf.lab.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MinimalPdfExportService {

    public Path exportSimplePdf(String fileNamePrefix, String title, List<String> lines) {
        try {
            Path targetDir = buildTargetDir();
            Files.createDirectories(targetDir);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path target = targetDir.resolve(fileNamePrefix + "_" + timestamp + ".pdf");
            Files.writeString(target, buildPdfDocument(title, lines), StandardCharsets.ISO_8859_1);
            return target;
        } catch (IOException exception) {
            throw new IllegalStateException("Could not export simple PDF demo file.", exception);
        }
    }

    private Path buildTargetDir() {
        Path downloads = Path.of(System.getProperty("user.home"), "Downloads");
        if (Files.exists(downloads)) {
            return downloads;
        }
        return Path.of(System.getProperty("user.home"));
    }

    private String buildPdfDocument(String title, List<String> lines) {
        StringBuilder textContent = new StringBuilder();
        textContent.append("BT\n/F1 18 Tf\n50 780 Td\n(").append(escapePdf(title)).append(") Tj\n");
        textContent.append("/F1 11 Tf\n0 -28 Td\n");
        for (String line : lines) {
            textContent.append("(").append(escapePdf(line)).append(") Tj\n0 -18 Td\n");
        }
        textContent.append("ET");

        String contentStream = textContent.toString();

        StringBuilder pdf = new StringBuilder();
        List<Integer> offsets = new java.util.ArrayList<>();
        pdf.append("%PDF-1.4\n");

        offsets.add(pdf.length());
        pdf.append("1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n");

        offsets.add(pdf.length());
        pdf.append("2 0 obj\n<< /Type /Pages /Kids [3 0 R] /Count 1 >>\nendobj\n");

        offsets.add(pdf.length());
        pdf.append("3 0 obj\n<< /Type /Page /Parent 2 0 R /MediaBox [0 0 595 842] /Contents 4 0 R /Resources << /Font << /F1 5 0 R >> >> >>\nendobj\n");

        offsets.add(pdf.length());
        pdf.append("4 0 obj\n<< /Length ").append(contentStream.length()).append(" >>\nstream\n");
        pdf.append(contentStream).append("\nendstream\nendobj\n");

        offsets.add(pdf.length());
        pdf.append("5 0 obj\n<< /Type /Font /Subtype /Type1 /BaseFont /Helvetica >>\nendobj\n");

        int xrefStart = pdf.length();
        pdf.append("xref\n0 6\n");
        pdf.append("0000000000 65535 f \n");
        for (Integer offset : offsets) {
            pdf.append(String.format("%010d 00000 n \n", offset));
        }
        pdf.append("trailer\n<< /Size 6 /Root 1 0 R >>\nstartxref\n");
        pdf.append(xrefStart).append("\n%%EOF");
        return pdf.toString();
    }

    private String escapePdf(String value) {
        return value.replace("\\", "\\\\").replace("(", "\\(").replace(")", "\\)");
    }
}

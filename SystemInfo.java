function runDetection() {
    // 1. Deteksi CPU (Jumlah Thread)
    const cpuThreads = navigator.hardwareConcurrency || "Tidak Terdeteksi";
    
    // 2. Deteksi RAM (Estimasi GB)
    const ramGb = navigator.deviceMemory || "Bawah 4";

    // 3. Deteksi Nama GPU (Kartu Grafis) - Teknik WebGL
    let gpuName = "Tidak Terdeteksi";
    try {
        const canvas = document.createElement('canvas');
        const gl = canvas.getContext('webgl') || canvas.getContext('experimental-webgl');
        const debugInfo = gl.getExtension('WEBGL_debug_renderer_info');
        gpuName = gl.getParameter(debugInfo.UNMASKED_RENDERER_WEBGL);
    } catch (e) {
        gpuName = "Akses GPU Ditolak Browser";
    }

    // 4. Deteksi OS & Model (User Agent)
    const platform = navigator.platform;

    // Update Tampilan ke HTML
    document.getElementById('cpuText').innerHTML = `<b>Prosesor:</b> ${cpuThreads} Core Threads`;
    document.getElementById('ramText').innerHTML = `<b>RAM:</b> Estimasi ${ramGb} GB`;
    
    // Tambahkan baris baru untuk GPU di info-box kamu nanti
    const infoBox = document.querySelector('.info-box');
    infoBox.innerHTML += `<div style="margin-top:10px; font-size:0.85rem; color:#60a5fa;"><b>GPU:</b> ${gpuName}</div>`;
    infoBox.innerHTML += `<div style="font-size:0.85rem; color:#888;"><b>OS:</b> ${platform}</div>`;

    // Sisanya (Chart & Game List) tetap sama seperti sebelumnya
    updateChart(cpuThreads, ramGb);
    updateGameList(ramGb);
}

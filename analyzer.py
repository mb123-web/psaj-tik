import platform

def show_info():
    print("=== BACKEND SYSTEM CHECKER ===")
    print(f"OS: {platform.system()} {platform.release()}")
    print(f"Machine: {platform.machine()}")
    print("Status: Berhasil diintegrasikan ke repositori.")

if __name__ == "__main__":
    show_info()

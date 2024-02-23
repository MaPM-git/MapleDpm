package org.mapledpmlab.type.skill.attackskill.wildhunter;

public class RampageAsOne extends JaguarSkill {
    public RampageAsOne() {
        this.setName("램피지 애즈 원");
        this.setDamage(1120.0);
        this.setAttackCount(9L);
        this.setCooldown(12.0);
        this.setAddDamage(20L);             // 서먼 재규어-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
        this.setJaguarDelay(1440L);
    }
}

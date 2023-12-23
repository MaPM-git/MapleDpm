package org.mapledpmlab.type.skill.attackskill.wildhunter;

public class ClawCut extends JaguarSkill {
    public ClawCut() {
        this.setName("클로우 컷");
        this.setDamage(230.0 + 30 + 40 + 50 + 150);
        this.setAttackCount(4L);
        this.setCooldown(5.0);
        this.setAddDamage(20L);             // 서먼 재규어-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setJaguarDelay(1530L);
    }
}

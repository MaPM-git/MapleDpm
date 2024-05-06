package org.mapledpmlab.type.skill.attackskill.wildhunter;

public class SonicBoom extends JaguarSkill {
    public SonicBoom() {
        this.setName("소닉붐");
        this.setDamage(728.0 + 50 + 150);
        this.setAttackCount(6L);
        this.setCooldown(6.0);
        this.setAddDamage(20L);             // 서먼 재규어-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setJaguarDelay(960L);
        this.setApplyReuse(true);
    }
}

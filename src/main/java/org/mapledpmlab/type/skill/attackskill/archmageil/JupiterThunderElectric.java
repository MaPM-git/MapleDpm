package org.mapledpmlab.type.skill.attackskill.archmageil;

public class JupiterThunderElectric extends ThunderAttack {
    public JupiterThunderElectric() {
        this.setName("주피터 썬더(전류)");
        this.setDamage(440.0);
        this.setAttackCount(4L);
        this.setDotDuration(30000L);
        this.setInterval(660L);
        this.setLimitAttackCount(15L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);       // 코어강화
    }
}

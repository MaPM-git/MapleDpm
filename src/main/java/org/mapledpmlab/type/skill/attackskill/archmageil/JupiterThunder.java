package org.mapledpmlab.type.skill.attackskill.archmageil;

public class JupiterThunder extends ThunderAttack {
    public JupiterThunder() {
        this.setName("주피터 썬더");
        this.setDamage(880.0);
        this.setAttackCount(8L);
        this.setCooldown(120.0);
        this.setDelay(810L);
        this.setDotDuration(30000L);
        this.setInterval(330L);
        this.setLimitAttackCount(30L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);       // 코어강화
        //this.setRelatedSkill(new JupiterThunderElectric());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}

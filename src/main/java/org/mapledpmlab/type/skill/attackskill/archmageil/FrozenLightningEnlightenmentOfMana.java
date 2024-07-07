package org.mapledpmlab.type.skill.attackskill.archmageil;

public class FrozenLightningEnlightenmentOfMana extends ThunderAttack {
    public FrozenLightningEnlightenmentOfMana() {
        this.setName("프로즌 라이트닝(마력 개화)");
        this.setAttackCount(15L);
        this.setDamage(1680.0);
        this.setDotDuration(30000L);
        this.setInterval(2000L);
        this.setAddDamage(50L + 60);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}

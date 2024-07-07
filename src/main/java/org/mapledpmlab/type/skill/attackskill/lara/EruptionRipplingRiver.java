package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EruptionRipplingRiver extends AttackSkill {
    public EruptionRipplingRiver() {
        this.setName("분출 : 너울이는 강");
        this.setDelayByAttackSpeed(450L);
        this.setDamage(1050.0);
        this.setAttackCount(5L);
        this.setCooldown(12.0);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setRelatedSkill(new EruptionRipplingRiverBig());
        this.getMultiAttackInfo().add(1170L);
        this.getMultiAttackInfo().add(3170L - 1170);
        this.getMultiAttackInfo().add(7530L - 3170);
        this.getMultiAttackInfo().add(9530L - 7530);
        this.getMultiAttackInfo().add(13890L - 9530);
        this.getMultiAttackInfo().add(15890L - 13890);
        this.addIgnoreDefenseList(15L);     // 분출/흡수 - 이그노어 가드
        this.setAddDamage(10L + 15 + 21);   // 분출/흡수 - 리인포스, 보스 킬러
    }
}

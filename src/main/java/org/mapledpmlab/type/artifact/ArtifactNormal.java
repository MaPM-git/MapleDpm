package org.mapledpmlab.type.artifact;

public class ArtifactNormal extends Artifact {

    public ArtifactNormal() {
        this.setDescription("아티팩트" +
                "\n1.올스탯 150" +
                "\n2.최대 HP 7500" +
                "\n3.공격력/마력 30" +
                "\n4.보스 공격 시 데미지 15%" +
                "\n5.몬스터 방어율 무시 20%" +
                "\n6.버프 지속시간 20%" +
                "\n7.재사용 대기시간 미적용 7.5%" +
                "\n8.크리티컬 확률 20%" +
                "\n9.크리티컬 데미지 4%" +
                "\n10.파이널 어택류 스킬의 데미지 30%" +
                "\n11.다수 공격 스킬의 최대 공격 가능 대상 수 1 증가" +
                "\n12.데미지 15%"
        );
        this.addMainStat(150L);
        this.addSubStat(150L);
        this.addOtherStat1(150L);
        this.addOtherStat2(150L);
        this.addHp(7500L);
        this.addAtt(30L);
        this.addMagic(30L);
        this.addDamage(15L);
        this.addIgnoreDefenseList(20L);
        this.addPlusBuffDuration(20L);
        this.addReuse(7.5);
        this.addCriticalP(20.0);
        this.addCriticalDamage(4.0);
        this.addDamage(15L);
    }
}

package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BuffBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class ArchMageFP5Continuous extends Job {

    public ArchMageFP5Continuous() {
        // 기본
        super();
        this.setName("아크메이지(불,독)(5초, 컨티)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(3256155.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (406 + 250 + 72 + 276));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat((long) (10 + 80 + 75));
        passive.addSubStat(75L);
        passive.addAtt(45L);
        passive.addMagic((long) (1 + 45));
        //passive.addBossDamage(70L);
        //passive.addMagicP(9L);
        passive.addBossDamage(30L);
        passive.addMagicP(21L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("메디테이션");
        passive.addMagic(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("매직 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스펠 마스터리");
        passive.addMagic(10L);
        passive.addCriticalP(5.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하이 위즈덤");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("엘리멘탈 리셋");
        passive.addProperty(10L);
        passive.addFinalDamage(1.4);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("매직 크리티컬");
        passive.addCriticalP(30.0);
        passive.addCriticalDamage(13.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("앨리먼트 앰플리케이션");
        passive.addDamage(50L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("아케인 에임");
        passive.addIgnoreDefenseList(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("마스터 매직");
        passive.addMagic(33L);
        passive.addPlusBuffDuration(55L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("언스태이블 메모라이즈");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(0L);
        this.addMainStat(4L);
        this.addSubStat(5L);

        this.setAbility(new BuffBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new IntUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("익스트림 매직");
        doping.addFinalDamage(1.13);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("아케인 에임");
        doping.addDamage(40L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("마스터 매직(콜렉터의 영약)");
        doping.addMagic(3L);
        doping.addPlusBuffDuration(5L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("메디테이션(콜렉터의 영약)");
        doping.addMagic(-30L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
